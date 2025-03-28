import axios from 'axios';


const http = axios.create({
    headers: {
        'Access-Control-Allow-Methods': "GET, POST, OPTIONS",
        'Access-Control-Allow-Headers': "Origin, X-Requested-With, Content-Type, Accept",
        'Access-Control-Allow-Origin': 'http://localhost:3000',
        'Content-Type': 'application/json',
        // 'X-RapidAPI-Host': "google-api31.p.rapidapi.com", //this is not working
        // 'X-RapidAPI-Host': "openl-translate.p.rapidapi.com", //use this instead
        // 'X-RapidAPI-Key': "YOUR_RAPIDAPI_KEY",
        // 'X-RapidAPI-Ua': "RapidAPI-Playground"
    },
    // withCredentials: true
})

export default http;