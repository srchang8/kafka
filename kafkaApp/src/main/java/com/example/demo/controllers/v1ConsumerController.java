package com.example.demo.controllers;

import com.example.demo.model.DBRecord;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Tag(name = "Consumer")
public class v1ConsumerController {
    @RequestMapping(method = RequestMethod.GET, path = "/dbrecord")
    @Operation(summary = "Get record", responses = {
            @ApiResponse(description = "Get record success", responseCode = "200",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = DBRecord.class))),
            @ApiResponse(description = "record not found",responseCode = "409",content = @Content)
    })
    public ResponseEntity<DBRecord> getDBRecord(String id) {
        if ("1".equals(id)) {
            DBRecord dbRecord = new DBRecord();
            dbRecord.setId("1");
            dbRecord.setName("Live Code");
            return ResponseEntity.ok(dbRecord);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Not found");
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/dbrecord")
    public ResponseEntity<Void> updateRecord(DBRecord record) {
        // Update record logic here ...

        return ResponseEntity.ok().build();
    }
}
