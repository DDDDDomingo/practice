package dataType

import "fmt"

func initNumber(){
	var valueDefault int
	fmt.Println("int类型无初始化", valueDefault)

	//int类型初始化
	var valueInt1, valueInt2 int = 1, 2
	fmt.Println(valueInt1, valueInt2)
}
