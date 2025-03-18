import '../../styles/Login.css';
import { useState, useCallback } from 'react';
import { Container, Row, Col, Form, Button} from "react-bootstrap";
//import { AdminDashboard } from './AdminDashboard';
import { useNavigate } from 'react-router';

export default function Login() {
    const [validated, setValidated] = useState(false);
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    // useCallback(() => {
    //     if (username === 'admin@gmail.com' && password === 'password') {
    //         navigate('/admin');
    //     } else {
    //         navigate('/user');
    //     }
    // },[username, navigate, password]);

    const handleSubmit = (event) => {
        event.preventDefault();
        const form = event.currentTarget;
        if (form.checkValidity() === false) {
            event.stopPropagation();
        }

        if (username === 'admin@gmail.com' && password === 'password') {
            navigate('/admin');
        } else {
            navigate('/user');
        }
        setValidated(true);

    }

    return (
        <Container>
            <Row className="justify-content-md-center mt-5">
                <Col xs={12} md={6}>
                    <h2 className="text-center mb-4 login-title">Login</h2>
                    <Form noValidate validated={validated} onSubmit={handleSubmit}>
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label>Email/ Username</Form.Label>
                            <Form.Control
                                type="email"
                                placeholder="Enter email or username"
                                value={username}
                                onChange={(e) => setUsername(e.target.value)}
                            />
                            <Form.Control.Feedback type="invalid">
                                Please enter Username or Email.
                            </Form.Control.Feedback>
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="formBasicPassword">
                            <Form.Label>Password</Form.Label>
                            <Form.Control
                                type="password"
                                placeholder="Password"
                                value={password}
                                onChange={(e) => setPassword(e.target.value)}
                            />
                            <Form.Control.Feedback type="invalid">
                                Please enter a valid password.
                            </Form.Control.Feedback>
                        </Form.Group>

                        <Button variant="primary" type="submit" className="w-100">
                            Login
                        </Button>
                    </Form>
                </Col>
            </Row>
        </Container>
    );
}