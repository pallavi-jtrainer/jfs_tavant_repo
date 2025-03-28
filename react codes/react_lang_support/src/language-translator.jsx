import { useState } from "react";
import axios from "axios";

export default function LanguageTranslator() {
    const [inputString, setInputString] = useState('');
    const [translatedText, setTranslatedText] = useState('');
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState('');

    const handleInputChange = (e) => {
        setInputString(e.target.value);
    };

    const handleTranslate = async () => {
        if (!inputString.trim()) {
            setError('Please enter some text to translate.');
            return;
        }

        setLoading(true);
        setError(''); // Clear any previous errors

        try {
            const response = await axios.post(
            'https://openl-translate.p.rapidapi.com/translate',
            {
                "target_lang": "en",
                "source_lang": "la",
                "text": inputString,
            }, // No body data needed in the POST request
            {
                // params: {
                //     text: inputString, // Text to translate
                //     from: 'en', // Source language (Latin)
                //     to: 'fr', // Target language (English)
                // },
                headers: {
                'X-RapidAPI-Key': 'YOUR_RAPID_API_KEY',
                'X-RapidAPI-Host': 'openl-translate.p.rapidapi.com',
                },
            }
        );
        console.log("Response: " + response.data.translatedText);
        // Set the translated text from the response
        setTranslatedText(response.data.translatedText);
        } catch (err) {
            setError('Translation failed. Please try again later.');
            console.error('API Error:', err);
        } finally {
            setLoading(false);
        }
    };

    return (
        <div>
            <h1>OpenL-Translate API Translator</h1>
            <div>
                <textarea
                    value={inputString}
                    onChange={handleInputChange}
                    placeholder="Enter text to translate"
                    rows="4"
                    cols="50"
                />
            </div>
            <button onClick={handleTranslate} disabled={loading}>
                {loading ? 'Translating...' : 'Translate'}
            </button>

            {error && <p style={{ color: 'red' }}>{error}</p>}

            {translatedText && (
                <div>
                    <h3>Translated Text:</h3>
                    <p>{translatedText}</p>
                </div>
            )}
        </div>
    );


}