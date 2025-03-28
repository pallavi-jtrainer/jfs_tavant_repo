import React, { useState, useEffect } from 'react';
import axios from 'axios';

const TodoTranslatorApp = () => {
    const [todos, setTodos] = useState([]);
    const [translatedTodos, setTranslatedTodos] = useState([]);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState('');

    // Fetch Todos from JSONPlaceholder
    useEffect(() => {
        const fetchTodos = async () => {
        setLoading(true);
        setError('');
        try {
            // Fetch todos from JSONPlaceholder API
            const response = await axios.get('https://fake-json-api.mock.beeceptor.com/notifications');
            console.log('Notifications ' + response.data);
            setTodos(response.data);
            translateTodos(response.data); // Translate todos once they are fetched
        } catch (err) {
            setError('Failed to fetch todos.');
            console.log('Error fetching todos:', err);
        } finally {
            setLoading(false);
        }
        };

        fetchTodos();
    }, []);

    // Translate the todos into French using OpenL-Translate API
    const translateTodos = async (todos) => {
        try {
            // Map through the todos and send each title and body for translation
            const translatePromises = todos.map((task) =>
                Promise.all([
                    axios.post(
                        'https://openl-translate.p.rapidapi.com/translate',
                        {
                            text: task.title,
                            target_lang: "fr",
                            // from: 'en',
                            // to: 'fr',
                        },
                        {
                        params: {
                            // text: task.title,
                            // from: 'en', // From English
                            // to: 'fr', // To French
                        },
                        headers: {
                            'X-RapidAPI-Key': 'YOUR_RAPIDAPI_KEY', // Replace with your RapidAPI key
                            'X-RapidAPI-Host': 'openl-translate.p.rapidapi.com',
                        },
                        }
                    ),
                //     axios.post(
                //         'https://openl-translate.p.rapidapi.com/translate',
                //         {
                //             text: task.message,
                //             from: 'en',
                //             to: 'fr',
                //         },
                //         {
                //         params: {
                //             // text: todo.body,
                //             // from: 'en', // From English
                //             // to: 'fr', // To French
                //         },
                //         headers: {
                //             'X-RapidAPI-Key': 'YOUR_RAPIDAPI_KEY', // Replace with your RapidAPI key
                //             'X-RapidAPI-Host': 'openl-translate.p.rapidapi.com',
                //         },
                //     }
                // ),
            ])
        );

        // Wait for all translations to complete
        const translatedResponses = await Promise.all(translatePromises);
        console.log(translatedResponses);

        // Map the translations back to the original todos
        const translatedTodos = todos.map((todo, index) => ({
            ...todo,
            translatedTitle: translatedResponses[index][0].data.translatedText, // Translated title
            // translatedBody: translatedResponses[index][1].data.translatedText, // Translated body
        }));

        // Update the translatedTodos state
        setTranslatedTodos(translatedTodos);
        } catch (err) {
        setError('Failed to translate todos.');
        console.error('Translation error:', err);
        }
    };

    return (
        <div>
        <h1>Todos Translated into French</h1>

        {loading && <p>Loading...</p>}

        {error && <p style={{ color: 'red' }}>{error}</p>}

        <div>
            <h3>Original Todos:</h3>
            <ul>
            {todos.length > 0 &&
                todos.map((todo) => (
                <li key={todo.id}>
                    {/* <strong>{todo.title}</strong>: {todo.message} */}
                    <strong>{todo.title}</strong>
                </li>
                ))}
            </ul>
        </div>

        <div>
            <h3>Translated Todos:</h3>
            <ul>
            {translatedTodos.length > 0 &&
                translatedTodos.map((todo) => (
                <li key={todo.id}>
                    {/* <strong>{todo.translatedTitle}</strong>: {todo.translatedBody} */}
                    <strong>{todo.translatedTitle}</strong>
                </li>
                ))}
            </ul>
        </div>
        </div>
    );
};

export default TodoTranslatorApp;