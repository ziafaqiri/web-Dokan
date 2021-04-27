import axios from "axios";
const axiosClient2 =axios.create({
    baseURL:"http://localhost:9090"
});


export default{
    getAllCrediator(){
        return axiosClient2.get("crediator/all");
    },
    AddCrediator(crediator){
        return axiosClient2.post("/crediator/Add" , crediator);
    }
}