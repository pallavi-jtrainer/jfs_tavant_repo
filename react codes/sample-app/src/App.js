// import logo from './logo.svg';
import { BrowserRouter, Route, Routes, Link } from 'react-router-dom';
import './App.css';
import MyComponent from './components/MyComponent';
import User from './components/User';
import { Profile } from './components/Profile';
import { Account } from './components/Account';

function App() {
  return (
    <BrowserRouter>
      <div>
        <nav>
          <Link to="/user">User</Link>
        </nav>
      </div>

      <Routes>
        <Route path='/user' element={<User/>}>
          <Route path='profile' element={<Profile/>}/>
          <Route path='account' element={<Account/>}/>
        </Route>
      </Routes>
    </BrowserRouter>

  );
}

export default App;
