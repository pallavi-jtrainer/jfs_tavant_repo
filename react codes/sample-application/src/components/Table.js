import TableBody from "./TableBody";
import TableHeader from "./TableHeader";

const Table = () => {
    let empData = [
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

    return (
        <div className="container">
            <table className="table table-striped">
                <TableHeader/>
                <TableBody data={empData}/>
            </table>
        </div>
    );
}

export default Table;

// export default function Table() {
//     return (
//         <div className="container">
//             <table className="table table-striped">
//                 <TableHeader/>
//                 <TableBody/>
//             </table>
//         </div>
//     );
// }