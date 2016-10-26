//
//  SimpleLabelView.m
//  genas
//
//  Created by Henadzi Stoma on 10/25/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import "SimpleLabelView.h"

@implementation SimpleLabelView

/*
// Only override drawRect: if you perform custom drawing.
// An empty implementation adversely affects performance during animation.
- (void)drawRect:(CGRect)rect {
    // Drawing code
}
*/
- (instancetype)init
{
  self = [super init];
  self.backgroundColor = [UIColor whiteColor];
  [self setTextColor:[UIColor blueColor]];
  return self;
}

- (void) setLabelText:(NSString *)labelText {
  [self setText:labelText];
}
@end
