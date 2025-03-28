
export default function TableBody(props) {
    const empData = props.data.map((row) => {
        return (
            <tr key={row.id}>
                <td>{row.id}</td>
                <td>{row.name}</td>
                <td>{row.role}</td>
            </tr>
        )
    })
    return (
        <tbody>
            {empData}
            {/* {empData.map((row, index) => {
                return(
                <tr key={index}>
                    <td>{row.id}</td>
                    <td>{row.name}</td>
                    <td>{row.role}</td>
                </tr>
                )
            })} */}
        </tbody>

        // <tbody>
        //     <tr>
        //         <td>1</td>
        //         <td>John Doe</td>
        //         <td>Software Engineer</td>
        //     </tr>
        //     <tr>
        //         <td>2</td>
        //         <td>Jane Doe</td>
        //         <td>Software Engineer</td>
        //     </tr>
        //     <tr>
        //         <td>3</td>
        //         <td>John Stark</td>
        //         <td>Software Tester</td>
        //     </tr>
        // </tbody>
    );
}