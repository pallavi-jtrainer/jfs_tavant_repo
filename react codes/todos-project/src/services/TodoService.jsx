// import axios from "axios";
import httpCommon from "./http-common";

export default class TodoService {

    getAllTodos() {
        // return axios.get('https://jsonplaceholder.typicode.com/todos');
        return httpCommon.get('/todos');
    }

    getTodoById(id) {
        // return axios.get(`https://jsonplaceholder.typicode.com/todos/${id}`);
        httpCommon.get('/todos/' + id);
    }

    createTodo(data) {
        // return axios.post(`https://jsonplaceholder.typicode.com/todos`, data);
        return httpCommon.post('/todos', data);
    }
}