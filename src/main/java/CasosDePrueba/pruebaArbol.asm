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
_x:main dd ?
_y:main dd ?
_4 dd 4
_2.0 dd 2.0
_5 dd 5
_5.0 dd 5.0
_10 dd 10
_54 dd 54

.code
invoke MessageBox, NULL, addr AutoinvocacionFunciones, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OverflowSumaEnteros, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OverflowProductoDouble, addr error, MB_OK 
invoke ExitProcess, 0 
main:
MOV EAX, 300
ADD EAX, 10
JO errorSumaEnteros
MOV @aux1, EAX
MOV EAX , @aux1
MOV x, EAX
MOV EAX, x
CMP EAX, y
JLE label2
MOV EAX , 4
MOV x, EAX
MOV EAX, x
CMP EAX, y
JGE label4
FLD 2.0
FADD 2.0
FST y
JMP label3
label4:
FLD 5.0
FST y
label3:
JMP label1
label2:
MOV EAX , 5
MOV x, EAX
label1:
invoke ExitProcess, 0 
end main