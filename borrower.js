import axios from "axios";
const axiosClient1 =axios.create({
    baseURL:"http://localhost:9090"
});


export default{
    getAllborrower(){
        return axiosClient1.get("borrower/all");
    },
    Addborrower(borrower){
        return axiosClient1.post("/borrower/Add" , borrower);
    }
}