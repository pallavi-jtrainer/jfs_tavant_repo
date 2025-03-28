import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Routes, Route, NavLink } from 'react-router-dom';
import TodoList from './components/TodoList';
import AddTodo from './components/AddTodo';
import TodoDetails from './components/TodoDetails';

function App() {
  return (
    <BrowserRouter>
        <div className="container">
          <nav className='navbar navbar-expand-lg navbar-light bg-light'>
            <ul className="navbar-nav">
              <li className='nav-item'>
                <NavLink to={"/list"} className="nav-link">Todo List</NavLink>
              </li>
              <li className='nav-item'>
                <NavLink to={"/add"} className="nav-link">Add New Todo</NavLink>
              </li>
              {/* <li className='nav-item'>
                <NavLink to={`/details/${id}`} className="nav-link">Todo Details</NavLink>
              </li> */}
            </ul>
          </nav>

          <Routes>
            <Route path="/list" element={<TodoList username="pallavi"/>}/>
            <Route path="/add" element={<AddTodo/>}/>
            <Route path="/details/:id" element={<TodoDetails/>}/>
          </Routes>

        </div>
    </BrowserRouter>
   
  );
}

export default App;
