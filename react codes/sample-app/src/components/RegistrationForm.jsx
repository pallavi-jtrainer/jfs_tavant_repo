import { Button, Card, FormControl, FormHelperText, Input, InputLabel, Stack, CardContent } from "@mui/material";
import { useState } from "react";

export const RegistrationForm = () => {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');
    // const [errors, setErrors] = useState([]);

    return(
        <div>
            <Card>
                <CardContent>
                    <form style={{paddingTop: "10px", paddingLeft: "500px"}}>
                        <Stack spacing={2} direction="row" sx={{marginBottom: 4}}>
                            <FormControl>
                                <InputLabel htmlFor="firstName">First Name:</InputLabel>
                                <Input autoFocus="true"
                                    id="firstName"
                                    name="firstName"
                                    value={firstName}
                                    onChange={(e) => setFirstName(e.target.value)}/>
                                    <FormHelperText id="helper-text">
                                        Please Enter Your First Name
                                    </FormHelperText>
                            </FormControl>
                        </Stack>
                        <Stack spacing={2} direction="row" sx={{marginBottom: 4}}>
                            <FormControl>
                                <InputLabel htmlFor="lastName">Last Name:</InputLabel>
                                <Input
                                    id="lastName"
                                    name="lastName"
                                    value={lastName}
                                    onChange={(e) => setLastName(e.target.value)}/>
                            </FormControl>
                        </Stack>
                        <Stack spacing={2} direction="row" sx={{marginBottom: 4}}>
                            <FormControl>
                                <InputLabel htmlFor="username">Username:</InputLabel>
                                <Input
                                    id="username"
                                    name="username"
                                    value={username}
                                    onChange={(e) => setUsername(e.target.value)}/>
                            </FormControl>
                        </Stack>
                        <Stack spacing={2} direction="row" sx={{marginBottom: 4}}>
                        <FormControl>
                            <InputLabel htmlFor="email">Email:</InputLabel>
                            <Input
                                type="email"
                                id="email"
                                name="email"
                                value={email}
                                onChange={(e) => setEmail(e.target.value)}/>
                        </FormControl>
                        </Stack>
                        <Stack spacing={2} direction="row" sx={{marginBottom: 4}}>
                        <FormControl>
                            <InputLabel htmlFor="password">First Name:</InputLabel>
                            <Input
                                type="password"
                                id="password"
                                name="password"
                                value={password}
                                onChange={(e) => setPassword(e.target.value)}/>
                        </FormControl>
                        </Stack>
                        <Stack spacing={2} direction="row" sx={{marginBottom: 4}}>
                        <FormControl>
                            <InputLabel htmlFor="confirm">Confirm Password:</InputLabel>
                            <Input
                                type="password"
                                id="confirm"
                                name="confirm"
                                value={confirmPassword}
                                onChange={(e) => setConfirmPassword(e.target.value)}/>
                        </FormControl>
                        </Stack>
                        <Stack spacing={2} direction="row" sx={{marginBottom: 4}}>
                            <Button variant="contained" type="submit">Register</Button>
                        </Stack>
                    </form>
                </CardContent>
            </Card>
        </div>
    );
}