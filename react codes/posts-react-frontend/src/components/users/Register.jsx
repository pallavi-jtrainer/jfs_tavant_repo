import { useState } from "react";
// import { CardBody, CardHeader, CardTitle, Container, Form } from "react-bootstrap";
import '../../styles/global-styles.css';

export default function Register() {
    let [firstName, setFirstName] = useState('');
    let [lastName, setLastName] = useState('');
    let [email, setEmail] = useState('');
    let [username, setUsername] = useState('');
    let [password, setPassword] = useState('');
    let [confirmPassword, setConfirmPassword] = useState('');

    // let minLength = 10;

    const [errors, setErrors] = useState({
        firstName: '',
        lastName: '',
        username: '',
        email: '',
        password: '',
        confirmPassword: ''
    });

    const clearForm = () => {
        setFirstName("");
        setLastName("");
        setUsername("");
        setEmail("");
        setPassword("");
        setConfirmPassword("");
    };

    const validateForm = () => {
        let valid = true;
        const regex = /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/i;
        const temp = {...errors};
        if(!firstName.trim()) {
            temp.firstName = 'First Name is required';
            valid = false;
        } else {
            temp.firstName = '';
        }

        if(!lastName.trim()) {
            temp.lastName = 'Last Name is required';
            valid = false;
        } else {
            temp.lastName = '';
        }

        if(!username.trim()) {
            temp.username = 'Username is required';
            valid = false;
        } else {
            temp.username = '';
        }

        if(!email.trim()) {
            temp.email = 'Email is required';
            valid = false;
        } else if(!regex.test(email)) {
            temp.email = 'Email is invalid';
            valid = false;
        } else {
            temp.email = '';
        }

        if(!password.trim()) {
            temp.password = "Password is Required";
            valid = false;
        } else if (password.length < 8) {
            temp.password = 'Password should have minimum of 8 characters';
            valid = false;
        } else {
            temp.password = '';
        }

        if(!confirmPassword.trim()) {
            temp.confirmPassword = "Confirm Password is Required";
            valid = false;
        } else if (confirmPassword.length < 8) {
            temp.confirmPassword = 'Password should have minimum of 8 characters';
            valid = false;
        } else {
            temp.confirmPassword = '';
        }

        setErrors(temp);
        return valid;
    }

    const handleRegister = (e) => {
        e.preventDefault();

        console.log(validateForm());

        if(validateForm()) {
            alert("Registration Successful")
            const user = {firstName, lastName, email, password};
            console.log(user);
        }
    }

    // const handleFirstNameChange = (e) => {
    //     const value = e.target.value;
    //     setFirstName(value);

    //     if(!value.trim()) {
    //         setError('FirstName cannot be empty');
    //         return false;
    //     } else {
    //         setError('');
    //         return true;
    //     }

    // }

    // const handleEmailChange = (e) => {
    //     setEmail(e.target.value);
    // }

    // const handleLastNameChange = (e) => {
    //     setLastName(e.target.value);
    // }

    // const handleUsernameChange = (e) => {
    //     const val = e.target.value;
    //     setUsername(val);

    //     if(!val.trim()) {
    //         setError('Username cannot be empty');
    //     } else if(val.length < minLength) {
    //         setError('Username should be at least 10 characters long');
    //     } else {
    //         setError('');
    //     }
    // }

    // const handlePasswordChange = (e) => {
    //     const val = e.target.value;
    //     setPassword(val);

    //     if(!val.trim()) {
    //         setError('Password cannot be empty');
    //         return false;
    //     } else if(val.length < minLength) {
    //         setError('Password should be at least 10 characters long');
    //         return false;
    //     } else {
    //         setError('');
    //         return true;
    //     }
    // }

    // const handleConfirmPasswordChange = (e) => {
    //     const val = e.target.value;
    //     setConfirmPassword(val);

    //     if(!val.trim()) {
    //         setError('Confirm Password cannot be empty');
    //         return false;
    //     }
    //     if(password !== confirmPassword) {
    //         setError("Password mismatch");
    //         return false;
    //     }
    //     return true;
    // }

    // // const checkPasswordMatch = () => {
    // //     // if(password !== confirmPassword) {
    // //     //     alert('Passwords do not match');
    // //     //     return false;
    // //     // }
    // //     // return true;
    // // }

    // const handleSubmit = (e) => {
    //     e.preventDefault();
    //     if(firstName !== '' || lastName !== '' || username !== '' || password !== '') {
    //         alert("Registration Unsuccessful");
    //     } else {
    //         alert("Registration Successful");
    //     }
    // }

    return(
        <>
            <div className="container">
                <div className="card">
                <div className="card-header">
                    <div className="card-title">
                        <h2>Registration Page</h2>
                    </div>
                </div>
                <div className="card-body">
                    <form className="form-horizontal">
                        <div className="form-group">
                            <label>First Name: </label>
                            <input name="firstName" placeholder="Enter First Name"
                                type="text"
                                className={`form-control ${errors.firstName ? 'is-invalid': ''}`}
                                value={firstName}
                                onChange={(e) => setFirstName(e.target.value)}/>
                                {errors.firstName && <div className="invalid-feedback">{errors.firstName}</div>}
                        </div>
                        <div className="form-group">
                            <label>Last Name: </label>
                            <input name="lastName" placeholder="Enter Last Name"
                                type="text"
                                className={`form-control ${errors.lastName ? 'is-invalid': ''}`}
                                value={lastName}
                                onChange={(e) => setLastName(e.target.value)}/>
                            {errors.lastName && <div className="invalid-feedback">{errors.lastName}</div>}
                        </div>
                        <div className="form-group">
                            <label>Email: </label>
                            <input name="email" placeholder="Enter Email"
                                type="email"
                                className={`form-control ${errors.email ? 'is-invalid': ''}`}
                                value={email}
                                onChange={(e) => setEmail(e.target.value)}/>
                            {errors.email && <div className="invalid-feedback">{errors.email}</div>}
                        </div>
                        <div className="form-group">
                            <label>Username: </label>
                            <input name="username" placeholder="Enter Username"
                                type="text"
                                className={`form-control ${errors.username ? 'is-invalid': ''}`}
                                value={username}
                                onChange={(e) => setUsername(e.target.value)}/>
                            {errors.username && <div className="invalid-feedback">{errors.username}</div>}
                        </div>
                        <div className="form-group">
                            <label>Password <sup>*</sup>: </label>
                            <input
                                value={password}
                                type="password"
                                className={`form-control ${errors.password ? 'is-invalid': ''}`}
                                onChange={(e) => setPassword(e.target.value)}
                                placeholder="Password"
                            />
                            {errors.password && <div className="invalid-feedback">{errors.password}</div>}
                        </div>
                        <div className="form-group">
                            <label>Confirm Password <sup>*</sup>: </label>
                            <input
                                value={confirmPassword}
                                type="password"
                                className={`form-control ${errors.confirmPassword ? 'is-invalid': ''}`}
                                onChange={(e) => setConfirmPassword(e.target.value)}
                                placeholder="Confirm Password"
                            />
                            {errors.confirmPassword && <div className="invalid-feedback">{errors.confirmPassword}</div>}
                        </div>
                        <div>
                        <button className="btn btn-success btnClass" onClick={(e) => handleRegister(e)}>Register Details</button>
                        <button className="btn btn-warning btnClass" style= {{'marginLeft': '3%'}} onClick={clearForm}>Reset Form</button>
                        </div>
                    </form>
                </div>
                </div>
            </div>
        </>
    );
}