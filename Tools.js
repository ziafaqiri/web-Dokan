import axios from "axios";
const axiosClient3 =axios.create({
    baseURL:"http://localhost:9090"
});


export default{
    getAllTools(){
        return axiosClient3.get("tool/all");
    },
    AddTools(tool){
        return axiosClient3.post("/tool/Add" , tool);
    }
}