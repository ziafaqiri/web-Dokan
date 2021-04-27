import axios from "axios";
const axiosClient5 =axios.create({
    baseURL:"http://localhost:9090"
});


export default{
    getAllexpense(){
        return axiosClient5.get("expensive/all");
    },
    Addexpense(expens){
        return axiosClient5.post("/expensive/Add" , expens);
    }
}