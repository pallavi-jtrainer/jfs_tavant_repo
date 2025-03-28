import { Component } from "react";

export default class TodoList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            todos: []
        }

        this.getAllTodos = this.getAllTodos.bind(this);
    }

    componentDidMount() {
        this.getAllTodos();
    }

    getAllTodos() {
        fetch("https://jsonplaceholder.typicode.com/todos")
        .then(response => response.json())
        .then(data => this.setState({ todos: data }));
    }

    render() {
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
                                {this.state.todos.map((todo) => {
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
}