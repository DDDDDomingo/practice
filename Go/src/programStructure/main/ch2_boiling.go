package main

import "fmt"

const boilingF = 212.0
const frezzingF = 32.0

func main() {
	//var f = boilingF
	//var c = (f - 32) * 5 / 9
	fmt.Printf("boiling point = %g°F or %g°C\n", boilingF, fToC(boilingF))
	fmt.Printf("frezzingF point = %g°F or %g°C\n", frezzingF, fToC(frezzingF))
}

func fToC(f float64) float64 {
	return (f - 32) * 5 / 9
}
