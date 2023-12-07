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
_1.12412412D+2 dd 1.12412412D+2
_1 dd 1
_x:main dd ?
_2 dd 2
_133.d-4 dd 133.d-4
_r:main dd ?
@print4 db "r", 0 

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
FLD 1.12412412D+2
FST r
MOV EAX, x
CMP EAX, 133.d-4
JGE label1
invoke MessageBox, NULL, addr @print1, addr printMensaje, MB_OK
label1:
FLD x
FCOM 133.d-4
JGE label2
invoke MessageBox, NULL, addr @print2, addr printMensaje, MB_OK
label2:
FLD x
FCOM 133.d-4
JGE label5
MOV EAX, 1
CMP EAX, x
JGE label4
invoke MessageBox, NULL, addr @print3, addr printMensaje, MB_OK
JMP label3
label4:
invoke MessageBox, NULL, addr @print4, addr printMensaje, MB_OK
label3:
label5:
invoke ExitProcess, 0 
end main