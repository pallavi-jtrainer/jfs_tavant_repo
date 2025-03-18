import { useState, useEffect } from "react";
import { styled } from '@mui/material/styles';
import TableCell, { tableCellClasses } from '@mui/material/TableCell';
import { Table,
    TableBody,
    TableContainer,
    TablePagination,
    TableHead,
    TableRow,
    Container,
    Paper} from '@mui/material';

const StyledTableCell = styled(TableCell)(({ theme }) => ({
    [`&.${tableCellClasses.head}`]: {
        backgroundColor: theme.palette.common.black,
        color: theme.palette.common.white,
    },
    [`&.${tableCellClasses.body}`]: {
        fontSize: 14,
    },
}));

const StyledTableRow = styled(TableRow)(({ theme }) => ({
    '&:nth-of-type(odd)': {
        backgroundColor: theme.palette.action.hover,
    },
    // hide last border
    '&:last-child td, &:last-child th': {
        border: 0,
    },
}));

export const TodosList = () => {
    const [page, setPage] = useState(0);
    const [rowsPerPage, setRowsPerPage] = useState(10);

    // Fetching data from API
    const [todos, setTodos] = useState([]);

    useEffect(() => {
        fetchTodos();
    }, []);

    const fetchTodos = async () => {
        // const response = await fetch(`https://jsonplaceholder.typicode.com/todos?_start=${page * rowsPerPage}&_limit=${rowsPerPage}`);
        const response = await fetch(`https://jsonplaceholder.typicode.com/todos`);
        const data = await response.json();
        setTodos(data);
    }

    const handleChangePage = (event, newPage) => {
        setPage(newPage);
    };

    const handleChangeRowsPerPage = (event) => {
        setRowsPerPage(+event.target.value);
        setPage(0);
    };

    return(
        <Container>
            <TableContainer component={Paper}>
                <Table sx={{ minWidth: 700 }} aria-label="customized table">
                    <TableHead>
                        <TableRow>
                            <StyledTableCell>Id</StyledTableCell>
                            <StyledTableCell align="right">Title</StyledTableCell>
                            <StyledTableCell align="right">User Id</StyledTableCell>
                            <StyledTableCell align="right">Completed</StyledTableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {todos.slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage).map((todo) => (
                            <StyledTableRow key={todo.id}>
                                <StyledTableCell component="th" scope="row">
                                        {todo.id}
                                </StyledTableCell>
                                <StyledTableCell component="th" scope="row">
                                        {todo.title}
                                </StyledTableCell>
                                <StyledTableCell align="right">{todo.userId}</StyledTableCell>
                                <StyledTableCell align="right">{todo.completed.toString()}</StyledTableCell>
                            </StyledTableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
            <TablePagination
                rowsPerPageOptions={[10, 25, 50]}
                component="div"
                count={todos.length}
                rowsPerPage={rowsPerPage}
                page={page}
                onPageChange={handleChangePage}
                onChangeRowsPerPage={handleChangeRowsPerPage}
            />
        </Container>
    );
}