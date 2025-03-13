// import logo from './logo.svg';
import './App.css';
// import Sample from './components/class-components/Sample';
import Student from './components/class-components/Student';
// import Hello from './components/Hello';
// import Table from './components/Table';

function App() {
  let student = {
    firstName: "Pallavi",
    lastName: "Prasad",
    age: 18
  }
  return (
    <>
      <div className="App">
        {/* <Hello name="Pallavi" email="pallavi@gmail.com"/> */}
        {/* <Table/> */}
        {/* <Sample name="Pallavi Prasad"/> */}
        <Student student={student}/>
      </div>
    </>
  );
}

export default App;
