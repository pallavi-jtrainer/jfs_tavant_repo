// import logo from './logo.svg';
import { BrowserRouter, Route, Routes, Link } from 'react-router-dom';
import './App.css';
// import MyComponent from './components/MyComponent';
import User from './components/User';
import { Profile } from './components/Profile';
import { Account } from './components/Account';
import { RegistrationForm } from './components/RegistrationForm';
import { Register } from './components/Register';
import { TodosList } from './components/TodosList';

function App() {
  return (
    <BrowserRouter>
      <div>
        <nav>
          <Link to="/user">User</Link>
          <Link to="/register" style={{marginLeft: '1%'}}>Register</Link>
          <Link to="/students" style={{marginLeft: '1%'}}>Students</Link>
          <Link to="/todos" style={{marginLeft: '1%'}}>Todos</Link>
        </nav>
      </div>

      <Routes>
        <Route path='/user' element={<User/>}>
          <Route path='profile' element={<Profile/>}/>
          <Route path='account' element={<Account/>}/>
        </Route>
        <Route path="/register" element={<RegistrationForm/>}/>
        <Route path="/students" element={<Register/>}/>
        <Route path="/todos" element={<TodosList/>}/>
      </Routes>
    </BrowserRouter>

  );
}

export default App;
