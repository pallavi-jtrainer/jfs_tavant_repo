// import logo from './logo.svg';
import './App.css';
import Register from './components/users/Register';
import Login from './components/users/Login';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import { AdminDashboard } from './components/users/AdminDashboard';
import { UserDashboard } from './components/users/UsersDashboard';

function App() {
  return (
    <BrowserRouter>
      <div>
        <nav className='navbar navbar-light bg-light'>
          <div className="container-fluid navStyle">
            <a className="navbar-brand" href="/home">Posts</a>
            <ul className="navbar-nav" style={{display: 'ruby'}}>
              <li className="nav-item">
                <Link to="/register" className='nav-link'>Register</Link>
              </li>
              <li className="nav-item">
                <Link to="/login" className='nav-link'>Login</Link>
              </li>
            </ul>
          </div>
        </nav>

        <Routes>
          <Route path="/register" element={<Register/>}/>
          <Route path="/login" element={<Login/>}/>
          <Route path='/admin' element={<AdminDashboard/>}/>
          <Route path="/user" element={<UserDashboard/>}/>
        </Routes>
      </div>
    </BrowserRouter>
    // <div >
    //  {/* <Register /> */}
    //  <Login/>
    // </div>
  );
}

export default App;
