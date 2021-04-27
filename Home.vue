<template>
  <v-container>

    <template>
      <div class="caro">

      <v-carousel 
       cycle
       show-arrows-on-hover>
        <v-carousel-item
          v-for="(item,i) in items"
          :key="i"
          :src="item.src"
        >

        <v-row
          class="fill-height"
          align="center"
          justify="center"
        >
          <div class="display-2 mozoa ">
           {{item.title}}
          </div>
        </v-row>

  </v-carousel-item>
 </v-carousel>
</div>
    </template>

    <v-row>
      <v-col  md4>
        <v-spacer style="text-align:right">
            <h1 class="display-1  mr-16 mt-10" style="color:rgb(120, 178, 196);">میزان درآمد</h1>
        </v-spacer>
       <template>
            <vc-donut
              background="white" foreground="grey"
              :size="200" unit="px" :thickness="30"
              has-legend legend-placement="top"
              :sections="sections" :total="100"
              :start-angle="0" :auto-adjust-text-size="true"
              @section-click="handleSectionClick"
              style="float:left">
              <h1>75%</h1>
            </vc-donut>

       </template>

      </v-col>

             <v-col cols="4" class="mt-5" md4 >
                <v-date-picker class="mt-3" v-model="picker" elevation="15"  :landscape="$vuetify.breakpoint.smAndUp" full-width no-title="no-title"></v-date-picker>
             </v-col>
             <v-col cols="10" class="md8">
               <span style="float:right">
                 <h2 style="color:rgb(120, 178, 196)">مفاد سالیانه دکان </h2>
               </span>
            <v-container fluid>
            <v-sparkline
              :value="value"
              :gradient="gradient"
              :smooth="radius || false"
              :padding="padding"
              :line-width="width"
              :stroke-linecap="lineCap"
              :gradient-direction="gradientDirection"
              :fill="fill"
              :type="type"
              :auto-line-width="autoLineWidth"
              auto-draw
              ></v-sparkline>
              <span style="text-align:center" class="mt-12">
                  <h4 style="color:grey">میزان سود سالیانه بر اساس ضرر و سود شما</h4>
              </span>
              
            </v-container>
             </v-col>
      
    </v-row>
  </v-container>
</template>

<script>
// import {GChart} from 'vue-google-charts'

const gradients = [
    ['#222'],
    ['#42b3f4'],
    ['grey', 'black', 'grey'],
    ['purple', 'violet'],
    ['#00c6ff', '#FfF', '#FF0'],
    ['#f22047', '#ffd100', '#1feaea'],
  ]
export default{
   
  data:()=>({
    picker: new Date().toISOString().substr(0, 10),
      width: 2,
      radius: 10,
      padding: 8,
      lineCap: 'round',
      gradient: gradients[5],
      value: [0, 2, 5, 9, 5, 10, 3, 5, 0, 0, 1, 8, 2, 9, 0],
      gradientDirection: 'top',
      gradients,
      fill: false,
      type: 'trend',
      autoLineWidth: false,
      sections: [
          { label: 'gold section', value: 50, color: 'gold' },
          { label: 'Green section', value: 25, color: 'green' },
          { label: 'Blue section', value: 25, color: 'darkblue' }
        ],
                items: [
                  {
              id: 'rack', src: 'https://mediashower.com/blog/wp-content/uploads/2017/03/calculate-1.jpg', title:'دیگر محاسبات را آسان تر از همیشه انجام دهید '
            },
            {
              id: 'subrack', src: 'https://thumbs.dreamstime.com/z/pile-paid-bills-occur-regular-basis-home-personal-expenses-calculator-used-to-calculate-monthly-services-pay-158768563.jpg' , title: 'بدون نیاز به ماشین حساب محاسبه کنید '
            },

            {
              id: 'parts', src: 'https://s3.amazonaws.com/forusall-401k-blog-stage/2018/07/how-to-calculate-employee-retention-rate.jpg' , title: 'تنها با اپلیکیشن دکان به تمام امور کاری تان رسیده گی کنید'
            },
            {
              id: 'admin', src: 'https://netran.net/mag/wp-content/uploads/2019/01/a1.jpg' , title: 'بهترین روش برای شیوهای قدیمی دکان اپلیکیشین'
            }
 
        ]


  }),
  methods: {
      handleSectionClick(section) {
        console.log(`${section.label} clicked.`);
      }
    }


}
    


</script>
<style >
.v-progress-circular{
  margin: 1rem;
  color: rgb(120, 178, 196);
}
.mozoa{
  color:white;
  background-color: rgba(0, 0, 0, 0.3);
  padding: 2%;

}
</style>