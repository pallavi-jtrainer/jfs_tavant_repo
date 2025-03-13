import { Component } from "react";

export default class Student extends Component {
    constructor(props) {
        super(props);
        this.state = {
            // firstName: "Pallavi",
            // lastName: "Prasad",
            // age: 18

            firstName: this.props.student.firstName,
            lastName: this.props.student.lastName,
            age: this.props.student.age
        };
    }

    updateStudentData() {
        this.setState({
            firstName: "Prithvi",
            lastName: "Raj"
        });
    }

    render() {
        return (
            <>
                <div>
                    <h2>Student Details:</h2>
                    <p>First Name: {this.state.firstName}</p>
                    <p>Last Name: {this.state.lastName}</p>
                    <p>Age: {this.state.age}</p>
                </div>
                <br />
                <div>
                    <button onClick={() => this.updateStudentData()}>Update Student</button>
                </div>
            </>
        );
    }
}