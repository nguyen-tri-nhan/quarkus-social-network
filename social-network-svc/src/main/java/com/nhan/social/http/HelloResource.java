package com.nhan.social.http;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import lombok.extern.jbosslog.JBossLog;
import org.eclipse.microprofile.openapi.annotations.Operation;

@Path(Resources.Job.HELLO)
@Produces({MediaType.APPLICATION_JSON})
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
@JBossLog
public class HelloResource {

    @GET
    @Operation(summary = "Say hello world")
    public String hello() {
        log.info("Sample log");
        return "hello world";
    }
}
