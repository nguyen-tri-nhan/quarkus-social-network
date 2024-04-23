package com.nhan.social.user.http;

import com.nhan.social.http.Resources;
import com.nhan.social.user.domain.CreateUserPayload;
import com.nhan.social.user.domain.User;
import com.nhan.social.user.service.UserService;
import io.smallrye.mutiny.Uni;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import lombok.extern.jbosslog.JBossLog;
import org.jetbrains.annotations.Blocking;

@Path(Resources.User.COLLECTION)
@Produces({MediaType.APPLICATION_JSON})
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
@JBossLog
public class UserResource {

    private final UserService userService;

    @POST
    @Blocking
    @Transactional
    public Uni<User> create(CreateUserPayload user) {

        return Uni
                .createFrom()
                .item(() -> userService.create(user));
    }
}
