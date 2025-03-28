import { useState } from "react";

const Student1 = (props) => {
    // let [firstName, setFirstName] = useState('Pallavi');
    // let [lastName, setLastName] = useState('Prasad');
    // let [age, setAge] = useState(18);
    let [firstName, setFirstName] = useState(props.student.firstName);
    let [lastName, setLastName] = useState(props.student.lastName);
    let [age, setAge] = useState(props.student.age);

    const handleStudentDataChange = (e) => {
        e.preventDefault();
        console.log("Current Student Details: " + firstName + ", " + lastName + ", " + age);
        // setFirstName('Prithvi');
        // setLastName('Raj');
        // setAge(18);
    }
    return (
        // <div>
        //     <h2>Student  Details:</h2>
        //     <p>First Name: {firstName}</p>
        //     <p>Last Name: {lastName}</p>
        //     <p>Age: {age}</p>
        //     <div>
        //         <button onClick={() => handleStudentDataChange()}> Update Student Details</button>
        //     </div>
        // </div>

        <div className="container">
            <div className="card">
                <div className="card-header bg-dark text-white">
                    <h3>Student Details</h3>
                </div>
                <div className="card-body">
                    <form className="form-horizontal">
                        <div className="form-group">
                            <label htmlFor="firstName">First Name</label>
                            <input type="text" id="firstName"
                                value={firstName}
                                className="form-control"
                                onChange={(e) => setFirstName(e.target.value)}/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="lastName">Last Name</label>
                            <input type="text" id="lastName"
                                value={lastName}
                                className="form-control"
                                onChange={(e) => setLastName(e.target.value)}/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="age">Age</label>
                            <input type="text" id="age"
                                value={age}
                                className="form-control"
                                onChange={(e) => setAge(e.target.value)}/>
                        </div>
                        <div>
                            <button className="btn btn-primary" onClick={handleStudentDataChange}>Update Student Details</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    )
}

export default Student1;