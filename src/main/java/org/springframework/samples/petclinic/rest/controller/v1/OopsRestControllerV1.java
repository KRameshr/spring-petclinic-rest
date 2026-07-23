package org.springframework.samples.petclinic.rest.controller.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implements the /oops endpoint declared in the OpenAPI spec: an
 * intentionally-failing endpoint used to demonstrate the error response
 * shape. It was documented in the spec but had no backing controller,
 * so calling it returned Spring's default unmapped-route 404 instead of
 * the documented 400.
 *
 * Known limitation: the spec's own 200 response for this operation is
 * explicitly described as "Never returned," which no real implementation
 * can satisfy alongside the 400 response also declared here. That
 * conflict is a pre-existing spec issue, not something introduced by
 * this change, and is left for a follow-up PR to resolve at the spec
 * level rather than by removing the endpoint.
 */
@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("api")
public class OopsRestControllerV1 {

    @GetMapping("/oops")
    public ResponseEntity<ProblemDetail> failingRequest() {
        ProblemDetail detail = ProblemDetail.forStatusAndDetail(
            HttpStatus.BAD_REQUEST,
            "This endpoint always fails, by design, to demonstrate the error response shape."
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(detail);
    }
}
