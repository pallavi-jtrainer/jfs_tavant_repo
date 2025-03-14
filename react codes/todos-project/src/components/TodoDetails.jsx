import { useState, useEffect} from 'react';
import { useParams } from 'react-router';


export default function TodoDetails() {
    let {id} = useParams();
    // let {id, title} = useParams();

    let [todo, setTodo] = useState({
        id: 0,
        title: '',
        userId: 0,
        completed: false
    });

    useEffect(() => {
        getTodo();
        // fetch(`https://jsonplaceholder.typicode.com/todos/${id}`)
        // .then(response => response.json())
        // .then(data => {
        //     console.log(data);
        //     setTodo(data);
        // });
    },[id]);

    const getTodo = () => {
        console.log(id)
        fetch(`https://jsonplaceholder.typicode.com/todos/` + id)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            setTodo(data);
        });
    }

    return(
        <div className='card'>
            <div className='card-header'>
                <h3>Todo Details</h3>
            </div>
            <div className='card-body'>
                <form className='form-horizontal'>
                    <div className='form-group'>
                        <label>Id</label>
                        <input type='text' className='form-control' value={todo.id} disabled />
                    </div>
                    <div className='form-group'>
                        <label>Title</label>
                        <input type='text' className='form-control' value={todo.title} />
                    </div>
                    <div className='form-group'>
                        <label>User Id</label>
                        <input type='number' className='form-control' value={todo.userId} disabled />
                    </div>
                    <div className='form-group'>
                        <label>Completed</label>
                        <input type='checkbox' className='form-control' checked={todo.completed} />
                    </div>
                    <div>
                        <button type='button' className='btn btn-primary'>Save Changes</button>
                    </div>

                </form>

            </div>
        </div>
    );
}