/************** conf.js**/
var Excel = require('exceljs');
var array=[];
var workbook = new Excel.Workbook();
    //some setup code
exports.read=function(){
workbook.xlsx.readFile('/home/rad/myfile.xlsx')
    .then(function() {
workbook.eachSheet(function(worksheet) {
worksheet.eachRow(function(row, rowNumber) {
array.push(row);
    });
});
return array;
});
}
/**********       spec.js */
describe('test suite', function(){
global.array.forEach(function(testSpec) {
    it('write your test here', function() {
        //test code here
console.log(testSpec);
    });
});
for(var i=0;i<global.array.length;i++){
var data=global.array[i];
(function (testSpec) {
    it('write your test here', function () {
      //test code here
console.log(testSpec);
    });
  })(global.array[i]);
}
    
});














