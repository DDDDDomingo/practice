// Echo1 prints its command-line arguments.
package main

import (
	"fmt"
	"os"
)

/**
os.Args是一个字符串(string)的切片(slice)
Tips:slice同Python一样，是一个简版的动态数组，切片是Go语言的基础概念用 s[i]  访问单个元素，用 s[m:n]  获取子序列(译
Tips：和python里的语法差不多)。序列的元素数目为len(s)。和大多数编程语言类似，区间索引时，Go言里也采用左闭右开形式
 */
func main() {
	/*
	var s, seq string
	for i := 1; i < len(os.Args); i++ {
		s += seq + os.Args[i]
		seq = " "
	}
	fmt.Println(s)
	*/

	//练习 1.1： 修改 echo  程序，使其能够打印 os.Args[0]  ，即被执行命令本身的名字。
	var s, seq string
	for i := 0; i < len(os.Args); i++ {
		s += seq + os.Args[i]
		seq = " "
	}
	fmt.Println(s)
}
