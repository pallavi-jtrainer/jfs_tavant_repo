import { useState, useEffect } from "react";
import { useNavigate } from "react-router";
import { Link } from "react-router-dom";
import TodoService from "../services/TodoService";

export default function TodoList() {
    const navigate = useNavigate();
    let [todos, setTodos] = useState([]);

    //useEffect is used only with data retrieval
    useEffect(
        () => {
            getTodos();
        }, []
    );

    const getTodos = () => {
        TodoService.getTodos().then((data) => {
            setTodos(data);
        })
        .catch((error) => {
            console.error(error);
        })
    }

    // async function getTodos() {
    //     const url = "https://jsonplaceholder.typicode.com/todos";
    //     const response = await fetch(url);

    //     if(!response.ok) {
    //         throw new Error('Unable to fetch data');
    //     }

    //     response.json().then((data) => {
    //         console.log(data);
    //         setTodos(data);
    //     })

    //     // fetch("https://jsonplaceholder.typicode.com/todos",
    //     // (req, res) => {
    //     //     res.json().then((data) => {
    //     //         console.log(data);
    //     //         setTodos(data);
    //     //     })
    //     // }
    //     // )
    // }

    const gotoAddTodo = () => {
        navigate("/add");
    }

    const gotoTodoDetailsPage = (id) => {
        navigate(`/details/${id}`);
    }

    return(
        <div className="container">
            <div>
                <button type="button" className="btn btn-success"
                onClick={gotoAddTodo}>Add New Todo</button>
            </div>
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
                                <th>Actions</th>
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
                                        <td>
                                            {/* <button type="button" className="btn btn-primary">Edit</button> */}
                                            <Link to={`/details/${todo.id}`}
                                            className="btn btn-info">Edit</Link>
                                        </td>
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