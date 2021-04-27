<template>
    
    <div>
        <!-- <v-container>
            <v-row dir="rtl" class="mr-5">
                <h1 class="display-1 mt-10 mb-10" style="color:red ;" >بخش فروشات</h1>
            </v-row>
        </v-container>
-->
        <v-container> 
            <v-row >
                <v-img src="../../public/image/carousel/Dokan-Logo.png" style="height:200px"></v-img>
            </v-row>
        </v-container>
        <v-container>
            <v-row>
                <h1 class="mx-auto mb-1 px-16" style="background-color: rgba(0, 0, 0, 0.1);"> <v-span style="color:white">بـخـش</v-span> <v-span style="color:green">فروشات</v-span>  </h1>
            </v-row>
        </v-container>
        <hr>
        
                       <v-simple-table height="300px">
                                  <template v-slot:default>
                                      <thead>
                                          <tr>
            
                                         <th>قیمت فروش</th>
                                         <th> موجودی در انبار</th>
                                         <th>نوعیت</th>
                                         <th>نام محصول</th>
                                        <th>عکس</th>
            
                                         </tr>
                                      </thead>
                                         <tbody>

                                      <tr
                                       v-for="item in desserts"
                                            :key="item.name"
                                      >
                                         <td>{{item.sell}}</td>
                                         <td>{{item.stock}}</td>
                                         <td>{{item.simple1}}</td>
                                         <td>{{item.name}}</td>
                                        <td><img :src="imageurl" style=" width: 50px ;  height: 50px;"></td>
                                        </tr>
                                        </tbody>
                                </template>
                            </v-simple-table>






                        
    </div>
</template>
<script>
import Sell from "../api/Sell"
export default {

        data(){
            const tool={
                name:null,
                simple1:null,
                number:null,
                sell:null,
                stock:null
            }
            return{
                tool,
                desserts:[{}]
            }
        },
    
       async mounted(){
           const response = await Sell.getAllSell();
           this.desserts = response.data; 
            },   
      

}
</script>
<style>

.a{
    
}
</style>