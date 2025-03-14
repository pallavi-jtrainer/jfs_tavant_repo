import { useState } from "react";

export default function Employee() {
    let employeeData = [
        {
            id:1,
            name: 'John Doe',
            role: 'Software Engineer'
        },
        {
            id:2,
            name: 'Jane Smith',
            role: 'Product Manager'
        },
        {
            id:3,
            name: 'Bob Johnson',
            role: ' UX Designer'
        },
        {
            id:4,
            name: 'Alice Johnson',
            role: 'Frontend Developer'
        },
        {
            id:5,
            name: 'Charlie Brown',
            role: 'Backend Developer'
        }
    ];

    let [empData, setEmpData] = useState(employeeData);
    let [name, setName] = useState('');
    let [role, setRole] = useState('');

    const handleSubmitEmployeeData = (e) => {
        e.preventDefault();

        // Add the new employee data to the existing state
        setEmpData([...empData, {
            id: empData.length + 1,
            name: name,
            role: role
        }]);

    }
    return (
        <div className="container-fluid">
            <div className="card">
                <div className="card-header">
                    Employee List
                </div>
                <div className="card-body">
                    <table className="table table-striped">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Role</th>
                            </tr>
                        </thead>
                        <tbody>
                            {empData.map((row, index) => {
                                return(
                                    <tr key={index}>
                                        <td>{row.id}</td>
                                        <td>{row.name}</td>
                                        <td>{row.role}</td>
                                    </tr>
                                )
                            })}
                        </tbody>
                    </table>
                </div>
            </div>
            <div>
                <form className="form-horizontal">
                    <div className="form-group">
                        <label htmlFor="name">Name</label>
                        <input type="text" id="name"
                            value={empData.name}
                            className="form-control"
                            onChange={(e) => setName(e.target.value)}/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="role">Role</label>
                        <input type="text" id="role"
                            value={empData.role}
                            className="form-control"
                            onChange={(e) => setRole(e.target.value)}/>
                    </div>
                    <div style={{marginTop: '2%'}}>
                        <button className="btn btn-primary"
                        onClick={handleSubmitEmployeeData} >Add New Employee</button>
                    </div>
                </form>
            </div>
        </div>
    );
}