package main

import (
	"fmt"
	"os"
	"strconv"
	"strings"
	"time"
)

func main() {

	var s string = os.Args[0]
	start := time.Now()
	fmt.Println(strconv.Itoa(start.Nanosecond()))
	for i := 0; i < 20; i++ {
		s += s + " strings Join method test"
	}
	end := time.Now()
	fmt.Println(strconv.Itoa(end.Nanosecond()))
	//fmt.Println(end.Sub(start))

	start2 := time.Now()
	fmt.Println(strconv.Itoa(start2.Nanosecond()))
	var s2 string
	for j := 0; j < 20; j++ {
		s2 += strings.Join(os.Args[0:], " strings Join method test")
	}
	end2 := time.Now()
	fmt.Println(strconv.Itoa(end2.Nanosecond()))

	fmt.Println(end.Sub(start))
	fmt.Println(end2.Sub(start2))
	//fmt.Println(reflect.TypeOf(end))
}
