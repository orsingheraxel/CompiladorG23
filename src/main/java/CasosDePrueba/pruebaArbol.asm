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
_1 dd 1
_x:main dd ?
_2 dd 2
_y:main dd ?
_4 dd 4
_5 dd 5

.code
invoke MessageBox, NULL, addr AutoinvocacionFunciones, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OverflowSumaEnteros, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OverflowProductoDouble, addr error, MB_OK 
invoke ExitProcess, 0 
main:
MOV EAX , 2
MOV x, EAX
MOV EAX , 4
MOV y, EAX
MOV EAX, 1
ADD EAX, y
MOV @aux1, EAX
MOV EAX , @aux1
MOV x, EAX
MOV EAX, x
CMP EAX, y
JLE label3
MOV EAX , 4
MOV x, EAX
JMP label1
label2:
MOV EAX , 5
MOV x, EAX
label1:
label3:
invoke ExitProcess, 0 
end main