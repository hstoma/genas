//
//  Spot4BooksCell.m
//  genas
//
//  Created by Henadzi Stoma on 11/3/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import "Spot4BooksCell.h"


@implementation Spot4BooksCell {
  UIView* rootView;
}
- (id)initWithFrame:(CGRect)frame
{
  self = [super initWithFrame:frame];
  if (self) {
    
    
    rootView = [[UIView alloc] initWithFrame:CGRectZero];
    [rootView setBackgroundColor:[UIColor grayColor]];
    [rootView setTag:99];
    UILabel *titleLabel = [[UILabel alloc] initWithFrame:CGRectMake(10, 10, 140, 20)];
    [titleLabel setTextColor:[UIColor whiteColor]];
    
    [titleLabel setTag:100];
    [rootView addSubview:titleLabel];
    [self.contentView addSubview:rootView];
    
    
  }
  
  return self;
  
}

-(void) setRealBounds:(CGSize) size {
  CGFloat y = (self.frame.size.height -size.height)/2;
  [rootView setFrame:CGRectMake(0, y, size.width, size.height)];
}

@end
