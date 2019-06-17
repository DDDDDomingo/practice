// Dup1 prints the text of each line that appears more than
// once in the standard input, preceded by its count.
package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func main() {
	/*
		counts := make(map[string]int)
		input := bufio.NewScanner(os.Stdin)
		for input.Scan() {
			counts[input.Text()]++
		}
		// NOTE: ignoring potential errors from input.Err()
		for line, n := range counts {
			if n > 1 {
				fmt.Printf("%d\t%s\n", n, line)
			}
		}
	*/
	counts := make(map[string]int)
	input := bufio.NewScanner(os.Stdin)
	for input.Scan() {
		for key := range counts {
			if strings.EqualFold(input.Text(), key) {
				fmt.Println("输入有重复字段，原字段为", key, "，冲突字段为：", input.Text(), "，目前总数为：", counts [key])
			}
		}
		if input.Text() == "end" {
			break
		}
		counts[input.Text()]++
	}
	// NOTE: ignoring potential errors from input.Err()
	for line, n := range counts {
		if n > 1 {
			fmt.Printf("%d\t%s\n", n, line)
		}
	}
}
