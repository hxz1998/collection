package io.axoniq.demo.giftcard.api;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

// Tag this command to use it as code sample in the documentation
// tag::IssueCardCommand[]
public record IssueCardCommand(@TargetAggregateIdentifier String id, int amount) {

}
// end::IssueCardCommand[]
