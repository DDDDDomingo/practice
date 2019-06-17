// Echo2 prints its command-line arguments
package main

import (
	"fmt"
	"os"
	"strconv"
)

func main() {
	/*
		s, sep := "", ""
		for _, arg := range os.Args[1:] {
			s += sep + arg
			sep = " "
		}
		fmt.Println(s)
	*/
	s, sep := "", ""
	for temp, arg := range os.Args[0:] {
		s += sep + arg
		sep = " "
		fmt.Println("该行的索引值为：" + strconv.Itoa(temp))
		fmt.Println("该行的值为：" + s)
	}
}
