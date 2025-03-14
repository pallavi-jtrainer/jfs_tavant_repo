import { useEffect, useState } from "react";

export default function ListTodos() {

    let [todos, setTodos] = useState([]);

    useEffect(
        () => {
            getTodos();
        }, []
    );

    async function getTodos() {
        const url = "https://jsonplaceholder.typicode.com/todos";
        const response = await fetch(url);

        if(!response.ok) {
            throw new Error('Unable to fetch data');
        }

        response.json().then((data) => {
            console.log(data);
            setTodos(data);
        })

        // fetch("https://jsonplaceholder.typicode.com/todos",
        // (req, res) => {
        //     res.json().then((data) => {
        //         console.log(data);
        //         setTodos(data);
        //     })
        // }
        // )
    }

    return(
        <div className="container">
            <div className="card">
                <div className="card-header">
                    <h3>Todos List</h3>
                </div>
                <div className="card-body">
                    <table className="table table-striped">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Title</th>
                                <th>User Id</th>
                                <th>Completed</th>
                            </tr>
                        </thead>
                        <tbody>
                            {todos.map((todo) => {
                                return(
                                    <tr key={todo.id}>
                                        <td>{todo.id}</td>
                                        <td>{todo.title}</td>
                                        <td>{todo.userId}</td>
                                        <td>{todo.completed.toString()}</td>
                                    </tr>
                                )
                            })}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}