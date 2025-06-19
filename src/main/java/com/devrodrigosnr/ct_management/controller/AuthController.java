package com.devrodrigosnr.ct_management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devrodrigosnr.ct_management.dto.AuthRequest;
import com.devrodrigosnr.ct_management.dto.AuthResponse;
import com.devrodrigosnr.ct_management.model.Usuario;
import com.devrodrigosnr.ct_management.security.JwtUtil;
import com.devrodrigosnr.ct_management.service.UsuarioService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UsuarioService usuarioService;
    private final JwtUtil jwtUtil;

    public AuthController(UsuarioService usuarioService, JwtUtil jwtUtil) {
        this.usuarioService = usuarioService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest loginRequest) {
        Usuario usuario = usuarioService.autenticar(loginRequest.email(), loginRequest.password());
        String token = jwtUtil.gerarToken(usuario.getEmail());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
