import axios from "axios";
const axiosClient4 =axios.create({
    baseURL:"http://localhost:9090"
});


export default{
    getAllSell(){
        return axiosClient4.get("sell/all");
    },
  
}