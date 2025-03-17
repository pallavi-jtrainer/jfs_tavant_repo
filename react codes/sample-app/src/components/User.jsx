import { Link, Outlet } from "react-router-dom";

export default function User() {
    return(
        <div>
            <h2>User Component</h2>

            <div>
                <nav>
                    {/* <Link to="/user/profile">Profile</Link>
                    <Link to="/user/account">Account</Link> */}
                    <Link to="profile" style={{marginRight: '2%'}}>Profile</Link>
                    <Link to="account">Account</Link>
                </nav>
                <Outlet/>
            </div>
        </div>
    );
}