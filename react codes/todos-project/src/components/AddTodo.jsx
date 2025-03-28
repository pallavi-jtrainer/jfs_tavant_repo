import { useState } from "react";


export default function AddTodo() {
    let [todo, setTodo] = useState({
        id: Math.random(),
        title: '',
        userId: 0,
        completed: false
    });

    const handleSubmit = (e) => {
        e.preventDefault();
        // setTodo({
        //     id: Math.random(),
        //     title: todo.title,
        //     userId: todo.userId,
        //     completed: todo.completed
        // });
        saveTodo();
    }

    async function saveTodo() {
        try {
            await fetch('https://jsonplaceholder.typicode.com/todos', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: todo
            });
            alert('Todo saved successfully');
        } catch (error) {
            console.error('Error saving todo:', error);
        }
    }

    return (
        <div className="card">
            <div className="card-header">
                <h3>Add Todo</h3>
            </div>
            <div className="card-body">
                <form className="form-horizontal">
                    <div className="form-group">
                        <label>Title</label>
                        <input type="text" className="form-control" placeholder="Enter title"
                            value={todo.title} onChange={(e) => setTodo({...todo, title: e.target.value })} />
                    </div>
                    <div className="form-group">
                        <label>User Id</label>
                        <input type="number" className="form-control" placeholder="Enter user id"
                            value={todo.userId} onChange={(e) => setTodo({...todo, userId: parseInt(e.target.value) })} />
                    </div>
                    <div>
                        <button type="submit" className="btn btn-primary" onClick={handleSubmit}>Add Todo</button>
                    </div>
                </form>
            </div>
        </div>
    );
}