// import logo from './logo.svg';
import './App.css';
import TodoList from './components/class-components/TodoList';
// import Sample from './components/class-components/Sample';
// import Student from './components/class-components/Student';
// import Employee from './components/Employee';
// import ListTodos from './components/ListTodos';
// import Student1 from './components/Student1';
// import UncontrolledForm from './components/UncontrolledForm';
// import AddTodo from './components/AddTodo';
// import Hello from './components/Hello';
// import Table from './components/Table';

function App() {
  // let student = {
  //   firstName: "Pallavi",
  //   lastName: "Prasad",
  //   age: 18
  // }
  return (
    <>
      <div className="container">
        {/* <Hello name="Pallavi" email="pallavi@gmail.com"/> */}
        {/* <Table/> */}
        {/* <Sample name="Pallavi Prasad"/> */}
        {/* <Student student={student}/> */}
        {/* <Student1 student={student}/> */}
        {/* <Employee/> */}
        {/* <UncontrolledForm/> */}
        {/* <ListTodos/> */}
        {/* <AddTodo/> */}
        <TodoList/>
      </div>
    </>
  );
}

export default App;
