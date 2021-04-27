import axios from "axios";
const axiosClient =axios.create({
    baseURL:"http://localhost:9090"
});


export default{
    getAllEmployee(){
        return axiosClient.get("employee/all");
    },
    AddEmployee(Employee){
        return axiosClient.post("/Employee/Add" , Employee);
    }
}