.386 
.model flat, stdcall 
option casemap :none  
include \masm32\include\windows.inc 
include \masm32\include\kernel32.inc 
include \masm32\include\masm32.inc  
includelib \masm32\lib\kernel32.lib 
includelib \masm32\lib\masm32.lib
include \masm32\include\user32.inc 
includelib \masm32\lib\user32.lib 

.data
AutoinvocacionFunciones db "Una funcion no puede llamarse a si misma.", 0 
OverflowSumaEnteros db "Se produjo un overflow en la suma de enteros.", 0 
OverflowProductoDouble db "Se produjo un un overflow en el producto de doubles.", 0 
error db "Error", 0 
printMensaje db "Print", 0 
_100 dd 100
_a:main dd ?
_b:main dd ?
_10 dd 10
@print2 db "false", 0 

.code
invoke MessageBox, NULL, addr AutoinvocacionFunciones, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OverflowSumaEnteros, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OverflowProductoDouble, addr error, MB_OK 
invoke ExitProcess, 0 
main:
MOV EAX , 100
MOV a, EAX
MOV EAX , 10
MOV b, EAX
MOV EAX, a
CMP EAX, b
JE label1
invoke MessageBox, NULL, addr @print1, addr printMensaje, MB_OK
label1:
invoke MessageBox, NULL, addr @print2, addr printMensaje, MB_OK
invoke ExitProcess, 0 
end main