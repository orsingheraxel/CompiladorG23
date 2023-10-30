package AnalisisLexico;

import java.util.HashMap;

public class TPR {
    private final HashMap<String, Integer> palabrasRes = new HashMap<String, Integer>();

    public TPR() {
        palabrasRes.put("IF", 257);
        palabrasRes.put("ELSE", 258);
        palabrasRes.put("END_IF", 259);
        palabrasRes.put("PRINT", 260);
        palabrasRes.put("CLASS", 261);
        palabrasRes.put("VOID", 262);
        palabrasRes.put("DO", 263);
        palabrasRes.put("UNTIL", 264);
        palabrasRes.put("IMPL", 265);
        palabrasRes.put("INT", 266);
        palabrasRes.put("USHORT", 267);
        palabrasRes.put("DOUBLE", 268);
        palabrasRes.put("RETURN", 275);
        palabrasRes.put("TOD",276);
        palabrasRes.put("CADENA",277);
        palabrasRes.put("FOR",281);
    }

    public Integer get(String key) {
        return palabrasRes.get(key);
    }

}

