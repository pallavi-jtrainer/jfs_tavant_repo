import { Box, Container, createTheme, Table, ThemeProvider, Typography, TableHead,TableBody, TableCell, TableRow } from "@mui/material";

const myTheme = createTheme({
    palette: {
        primary: {
            main: "#0129b1"
        },
        secondary: {
            main: "#891cbb"
        }
    },
    typography: {
        //fontFamily: ["Poppins", "sans-serif"],
        h2:{
            fontSize: "2rem",
            fontWeight: 600,
            color: "black"
        },
        h3:{
            fontSize: "1rem",
            fontWeight: 600,
            color: "darkblue",
            fontStyle: "italic"
        },
        tr:{
            fontWeight: 900
        }
    }
});

const students = [
    { id: 1, name: "John Doe", age: 18 },
    { id: 2, name: "Jane Smith", age:   19 },
    { id: 3, name: "Alice Johnson", age: 19 },
    { id: 4, name: "Bob Brown", age: 19 }
];

export const Register = () => {
    return(
        <ThemeProvider theme={myTheme}>
            <Container>
                <Typography variant="h2" sx={{my:4, textAlign: "center", color:"primary.main"}}>
                    Student List
                </Typography>
                <Box
                    sx={{
                        display: "flex",
                        flexDirection: {xs: "column", md: "row"},
                        justifyContent: "space-around",
                        gap: 2
                    }}
                >
                    <Table>
                        <TableHead sx={{bgcolor: "thistle"}}>
                            <TableRow>
                                <TableCell sx={{fontWeight: 600}}>ID</TableCell>
                                <TableCell sx={{fontWeight: 600}}>Name</TableCell>
                                <TableCell sx={{fontWeight: 600}}>Age</TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {students.map(student => (
                                <TableRow key={student.id}>
                                    <TableCell>{student.id}</TableCell>
                                    <TableCell>{student.name}</TableCell>
                                    <TableCell>{student.age}</TableCell>
                                </TableRow>
                            ))}
                        </TableBody>
                    </Table>
                </Box>
            </Container>
        </ThemeProvider>
    );
}