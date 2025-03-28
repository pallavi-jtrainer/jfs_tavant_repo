import { useEffect, useState } from "react";

export const useFetch = (url) => {
    const [data, setData] = useState([]);

    useEffect(() =>{
        fetch(url)
        .then(response => response.json())
        .then(info => setData(info))
        .catch(error => console.error('Error:', error));
    })

    return [data];
}